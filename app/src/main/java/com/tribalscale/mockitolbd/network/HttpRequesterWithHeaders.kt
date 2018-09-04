package com.tribalscale.mockitolbd.network

class HttpRequesterWithHeaders private constructor(val builder: HttpBuilder) {

    fun request(uri: String): String {
        return builder.withUrl(uri)
                .withHeader("Content-type: application/json")
                .withHeader("Authorization: Bearer")
                .request()
    }
}

private class HttpBuilder {

    private var uri: String? = null
    private val headers: MutableList<String>

    init {
        this.headers = ArrayList()
    }

    fun withUrl(uri: String): HttpBuilder {
        this.uri = uri
        return this
    }

    fun withHeader(header: String): HttpBuilder {
        this.headers.add(header)
        return this
    }

    fun request(): String {
        return uri!! + headers.toString()
    }
}