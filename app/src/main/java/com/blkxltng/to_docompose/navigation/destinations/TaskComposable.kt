package com.blkxltng.to_docompose.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.blkxltng.to_docompose.ui.screens.task.TaskScreen
import com.blkxltng.to_docompose.ui.viewmodels.SharedViewModel
import com.blkxltng.to_docompose.util.Action
import com.blkxltng.to_docompose.util.Constants

fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = Constants.TASK_SCREEN,
        arguments = listOf(navArgument(Constants.TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) {navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(Constants.TASK_ARGUMENT_KEY)
        sharedViewModel.getSelectedTask(taskId)
        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        LaunchedEffect(key1 = taskId) {
            sharedViewModel.updateTaskFields(selectedTask = selectedTask)
        }

        TaskScreen(
            selectedTask = selectedTask,
            sharedViewModel = sharedViewModel,
            navigateToListScreen = navigateToListScreen
        )
    }
}
