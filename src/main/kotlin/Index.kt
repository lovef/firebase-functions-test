/*
 * Date: 2017-05-21
 * @author Love
 */

external fun require(module: String): dynamic
external val exports: dynamic

fun main(args: Array<String>) {
    val functions = require("firebase-functions")
    val admin = require("firebase-admin")
    admin.initializeApp(functions.config().firebase)

    exports.kotlinHello = functions.https.onRequest { request, response ->
        val name = request.query.name
        response.status(200).send("Kotlin says Hello, $name")
    }
}
