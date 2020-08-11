package com.terrakube.cfdemo

import io.pivotal.cfenv.core.CfEnv
import io.pivotal.cfenv.jdbc.CfJdbcEnv
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource


@SpringBootApplication
class CfdemoApplication

@Bean
fun cfJdbcEnv(): CfJdbcEnv? {
	return CfJdbcEnv()
}

@Bean
fun cfEnv(): CfEnv? {
	return CfEnv()
}

@Bean
fun jdbcTemplate(dataSource: DataSource): JdbcTemplate {
	return JdbcTemplate(dataSource)
}

fun main(args: Array<String>) {
	runApplication<CfdemoApplication>(*args)
}