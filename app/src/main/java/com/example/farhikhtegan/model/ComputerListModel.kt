package com.example.farhikhtegan.model

class ComputerListModel(val name:String?=null, val img:String?=null) {
    override fun toString(): String {
        return name!!
    }
}