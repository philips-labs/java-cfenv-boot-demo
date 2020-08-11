package com.terrakube.cfdemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.sql.ResultSet
import java.util.*

data class Result(val date: String)

@RestController
class HtmlController {
    @Autowired
    private val jdbcTemplate: JdbcTemplate? = null

    fun getDBTime(): String? {
        var rowMapper: RowMapper<Result> = RowMapper<Result> { resultSet: ResultSet, _: Int ->
            Result(resultSet.getString("date"))
        }
        var results = jdbcTemplate?.query("SELECT to_char(now()::timestamp, 'DD Mon YYYY HH:MI:SSPM') AS date", rowMapper)

        return results?.get(0)?.date
    }

    @RequestMapping("/")
    fun index(): String {
        return "hello world: " + getDBTime()
    }
}