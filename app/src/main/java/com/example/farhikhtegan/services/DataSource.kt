package com.example.farhikhtegan.services

import com.example.farhikhtegan.model.ComputerListModel
import com.example.farhikhtegan.model.ListLanguageModel
import com.example.farhikhtegan.model.TeacherModel

class DataSource {
    val teachers= listOf(
        TeacherModel("محمد","ابراهیمی","teachera"),
        TeacherModel("زهرا","رهنما","teacherc"),
        TeacherModel("مرتضی","دروگر","teacherb"),
        TeacherModel("طاهره","رحمانی","teacherc"),
        TeacherModel("محمد","ابراهیمی","teacherc"),
        TeacherModel("زهرا","رهنما","teacherc"),
        TeacherModel("مرتضی","دروگر","teacherb"),
        TeacherModel("طاهره","رحمانی","teacherc"),
        TeacherModel("محمد","ابراهیمی","teachera"),
        TeacherModel("زهرا","رهنما","teacherc"),
        TeacherModel("مرتضی","دروگر","teacherb"),
        TeacherModel("طاهره","رحمانی","teacherc"),
        TeacherModel("محمد","ابراهیمی","teachera"),
        TeacherModel("زهرا","رهنما","teacherc"),
        TeacherModel("مرتضی","دروگر","teacherb"),
        TeacherModel("طاهره","رحمانی","teacherc"),
    )

    val Setting_language=listOf(
        ListLanguageModel("فارسی","flagiran"),
        ListLanguageModel("English","flagen"),
    )

    val computers= listOf(
        ComputerListModel("برنامه نویسی PHP","php"),
        ComputerListModel("php","php"),
        ComputerListModel("برنامه نویسی PHP","php"),
        ComputerListModel("php","php"),
        ComputerListModel("برنامه نویسی PHP","php"),
        ComputerListModel("php","php"),
        ComputerListModel("برنامه نویسی PHP","php"),
        ComputerListModel("php","php"),
    )
}