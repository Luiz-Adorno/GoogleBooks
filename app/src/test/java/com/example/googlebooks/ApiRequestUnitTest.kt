package com.example.googlebooks

import com.example.googlebooks.repository.BookHttp
import org.junit.Test

import org.junit.Assert.*

class ApiRequestUnitTest {
    @Test
    fun googleBooksApiTest() {
        val searchResult = BookHttp.searchBook("Dominando o Android")
        searchResult?.items?.forEach{ volume ->
            println(volume)
        }
    }
}