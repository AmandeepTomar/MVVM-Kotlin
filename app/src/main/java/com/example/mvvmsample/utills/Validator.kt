package com.example.mvvmsample.utills

object Validator {
    fun validateUserId(userId: String?, password: String?): String {
        return when {
            userId == null -> "Please enter user Id"
            userId.isEmpty() -> "User Id cant't be empty"
            userId.isBlank() -> "User Id can't be blank"
            password==null -> "Please enter password"
            password.isEmpty() -> "Password can not be empty"
            password.isBlank() -> "Password can not be blank"
            else -> AppConstant.VALIDATE
        }

}
}