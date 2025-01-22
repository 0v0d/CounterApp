package com.example.counterapp.view.counter.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.counterapp.R

@Composable
fun ResetConfirmationDialog(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(stringResource(id = R.string.Confirm)) },
        text = { Text(stringResource(id = R.string.ResetMessage)) },
        confirmButton = {
            TextButton(
                onClick = onConfirm,
            ) {
                Text(stringResource(id = R.string.Reset))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(id = R.string.Cancel))
            }
        }
    )
}
