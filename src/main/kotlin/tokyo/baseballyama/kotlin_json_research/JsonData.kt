package tokyo.baseballyama.kotlin_json_research

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class UserID(private val value: String)

@Serializable
@JvmInline
value class UserName(private val value: String)

@Serializable
@JvmInline
value class UserAge(private val value: Int)

@Serializable
@JvmInline
value class UserMemo(private val value: String)

@Serializable
@JvmInline
value class UserNote(private val value: String?)

@Serializable
data class User(val userId: UserID, val name: UserName, val age: UserAge, val memo: UserMemo?, val note: UserNote)
