package com.example.farhikhtegan.model

class TeacherModel(val firstName:String?=null,val lastName:String?=null,val image:String?=null) {

    override fun toString(): String {
        return firstName!!
    }


}