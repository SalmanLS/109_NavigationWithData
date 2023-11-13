package com.example.navdata

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.navdata.data.OrderUiState
import com.example.navdata.ui.komponen.FormatLabelHarga

@Composable
fun HalamanDua(
    orderUIState: OrderUiState,
    onCancelButtonClicked: () -> Unit,
    //onSendButtonClicked: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        Pair(stringResource(id = R.string.quantity), orderUIState.jumlah),
        Pair(stringResource(id = R.string.flavor), orderUIState.rasa),
    )
    val contact = listOf(
        Pair(stringResource(id = R.string.namap), orderUIState.nama),
        Pair(stringResource(id = R.string.nomorp), orderUIState.tlp),
        Pair(stringResource(id = R.string.alamatp), orderUIState.alamat),
    )
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            contact.forEach { item ->
                Column {
                    Text(item.first, fontWeight = FontWeight.Bold)
                    Text(text = item.second)
                }
                Divider(
                    thickness = dimensionResource(id = R.dimen.thickness_divider)
                )
            }
            items.forEach { item ->
                Column {
                    Text(item.first.uppercase())
                    Text(text = item.second.toString(), fontWeight = FontWeight.Bold)
                }
                Divider(
                    thickness = dimensionResource(id = R.dimen.thickness_divider)
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            FormatLabelHarga(
                subtotal = orderUIState.harga,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Row(
            modifier = Modifier
                .weight(1f, false)
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {}
                ) {
                    Text(stringResource(id = R.string.send))
                }
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onCancelButtonClicked
                ) {
                    Text(stringResource(id = R.string.cancel))
                }
            }
        }
    }
}