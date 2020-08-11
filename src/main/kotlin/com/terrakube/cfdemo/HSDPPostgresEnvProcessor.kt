package com.terrakube.cfdemo

import io.pivotal.cfenv.core.CfCredentials
import io.pivotal.cfenv.core.CfService
import io.pivotal.cfenv.spring.boot.CfEnvProcessor
import io.pivotal.cfenv.spring.boot.CfEnvProcessorProperties

class HSDPPostgresEnvProcessor : CfEnvProcessor {
    override fun accept(service: CfService?): Boolean {
        println("--> HSDPPostgresEnvProcessor: accept")
        if (service != null) {
            val accepted = service.existsByTagIgnoreCase("postgresql") &&
                    service.existsByUriSchemeStartsWith("postgres")
            println(accepted)
            return accepted
        }
        return false
    }

    override fun process(cfCredentials: CfCredentials?, properties: MutableMap<String, Any>?) {
        if (cfCredentials != null) {

            properties?.set("spring.datasource.url", "jdbc:postgresql://"+cfCredentials.host+":"+cfCredentials.port+"/"+cfCredentials.getString("db_name"))
            properties?.set("spring.datasource.username", cfCredentials.username)
            properties?.set("spring.datasource.password", cfCredentials.password)
            properties?.set("spring.datasource.driver-class-name", "org.postgresql.Driver")
        }
    }

    override fun getProperties(): CfEnvProcessorProperties {
        return CfEnvProcessorProperties.builder()
                .propertyPrefixes("spring.datasource")
                .serviceName("PostgreSQL")
                .build();
    }
}