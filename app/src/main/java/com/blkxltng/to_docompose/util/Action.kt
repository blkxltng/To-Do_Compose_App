package com.blkxltng.to_docompose.util

enum class Action {
    ADD,
    UPDATE,
    DELETE,
    DELETE_ALL,
    UNDO,
    NO_ACTION
}

fun String?.toAction(): Action {
    return when(this) {
        "ADD" -> Action.ADD
        "UPDATE" -> Action.UPDATE
        "DELETE" -> Action.DELETE
        "DELETE_ALL" -> Action.DELETE_ALL
        "UNDO" -> Action.UNDO
        else -> Action.NO_ACTION
    }
}