external fun require(module: String): dynamic
external val exports: dynamic

/**
 * Based on [this tutorial](https://medium.com/@LuhmirinS/setting-up-firebase-functions-with-kotlin-1c34b2ca2427).
 * See result: [Kotlin Hello](https://us-central1-functions-test-fc4cd.cloudfunctions.net/kotlinHello?name=Love)
 *
 * Date: 2017-05-21
 * @author Love
 */
fun main(args: Array<String>) {
    val functions = require("firebase-functions")
    val admin = require("firebase-admin")
    admin.initializeApp(functions.config().firebase)

    // https://us-central1-functions-test-fc4cd.cloudfunctions.net/kotlinHello?name=Love
    exports.kotlinHello = functions.https.onRequest { request, response ->
        val name = request.query.name
        response.status(200).send("Kotlin says Hello${if(name != null) ", $name" else "!"}")
    }
}
