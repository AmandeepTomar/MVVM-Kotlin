package com.example.mvvmsample.utills

object Validatror {
    fun validateUserId(userId: String?, password: String?): String {
        return when {
            userId == null -> "Please enter some value"
            userId.isEmpty() -> "Value cant't be empty"
            userId.isBlank() -> "Value can't be blank"
            password==null -> "Please enter password"
            password.isEmpty() -> "Password can not be empty"
            password.isBlank() -> "Password can not be blank"
            else -> AppConstant.VALIDATE
        }

}
}