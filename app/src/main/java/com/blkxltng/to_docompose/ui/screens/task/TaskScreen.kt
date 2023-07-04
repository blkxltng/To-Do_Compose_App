package com.blkxltng.to_docompose.ui.screens.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.blkxltng.to_docompose.data.models.Priority
import com.blkxltng.to_docompose.data.models.ToDoTask
import com.blkxltng.to_docompose.ui.viewmodels.SharedViewModel
import com.blkxltng.to_docompose.util.Action

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {

    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                TaskContent(
                    title = title,
                    onTitleChanged = {
                        sharedViewModel.title.value = it
                    },
                    description = description,
                    onDescriptionChanged = {
                        sharedViewModel.description.value = it
                    },
                    priority = priority,
                    onPrioritySelected = {
                        sharedViewModel.priority.value = it
                    }
                )
            }
        }
    )
}