package tokyo.baseballyama.kotlin_json_research

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.google.gson.GsonBuilder
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val user = User(UserID("abc123"), UserName("baseballyama"), UserAge(20), null, UserNote(null))
const val userJson = """{"userId":"abc123","name":"baseballyama","age":20,"memo":null,"note":null}"""

object Kotlinx {
    fun serialize(): String = Json.encodeToString(user)
    fun deserialize(): User = Json.decodeFromString(userJson)
}

object Jackson {
    private val mapper = jacksonObjectMapper()
    fun serialize(): String = mapper.writeValueAsString(user)
    fun deserialize(): User = mapper.readValue(userJson)
}

object Moshi {
    private val moshi = com.squareup.moshi.Moshi.Builder().build().adapter(User::class.java)
    fun serialize(): String = moshi.toJson(user)
    fun deserialize(): User = moshi.fromJson(userJson)!!
}

object Gson {
    private val gson = GsonBuilder().serializeNulls().create();
    fun serialize(): String = gson.toJson(user)
    fun deserialize(): User = gson.fromJson(userJson, User::class.java)
}

fun main() {
    myAssert(Kotlinx.serialize(), userJson)
    myAssert(Kotlinx.deserialize(), user)

    myAssert(Jackson.serialize(), userJson)
    // デシリアライザはサポートされていない?
    // https://github.com/FasterXML/jackson-module-kotlin/issues/199#issuecomment-1013810769
    // myAssert(Jackson.deserialize(), user)

    // サポートされていない?
    // https://github.com/square/moshi/issues/1170
    // myAssert(Moshi.serialize(), userJson)
    // myAssert(Moshi.deserialize(), user)

    myAssert(Gson.serialize(), userJson)
    myAssert(Gson.deserialize(), user)
}

fun myAssert(a: Any, b: Any) {
    if (a != b) throw AssertionError("$a != $b")
}