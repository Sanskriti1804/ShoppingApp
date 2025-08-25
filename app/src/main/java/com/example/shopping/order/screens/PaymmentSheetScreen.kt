import com.stripe.android.paymentsheet.PaymentSheet

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.stripe.android.PaymentConfiguration
import com.stripe.android.paymentsheet.PaymentSheetResult


@Composable
fun App() {
//    val paymentSheet = remember { PaymentSheet.Builder(::onPaymentSheetResult) }.build()


//    LaunchedEffect(context) {
//        // Make a request to your own server and retrieve payment configurations
//        val networkResult = ...
//        if (networkResult.isSuccess) {
//            paymentIntentClientSecret = networkResult.paymentIntent
//            customerConfig = PaymentSheet.CustomerConfiguration(
//                id = networkResult.customer,
//                ephemeralKeySecret = networkResult.ephemeralKey
//            )
//            PaymentConfiguration.init(context, networkResult.publishableKey)
//        }
//    }
//
    Button(
        onClick = {
//            val currentConfig = customerConfig
//            val currentClientSecret = paymentIntentClientSecret
//
//            if (currentConfig != null && currentClientSecret != null) {
//                presentPaymentSheet(paymentSheet, currentConfig, currentClientSecret)
//            }
//            presentPaymentSheet(paymentSheet, customerConfig, paymentIntentClientSecret)
        }
    ) {
        Text("Checkout")
    }
}

private fun presentPaymentSheet(
    paymentSheet: PaymentSheet,
    customerConfig: PaymentSheet.CustomerConfiguration,
    paymentIntentClientSecret: String
) {
    paymentSheet.presentWithPaymentIntent(
        paymentIntentClientSecret,
        PaymentSheet.Configuration.Builder(merchantDisplayName = "My merchant name")
            .customer(customerConfig)
            // Set `allowsDelayedPaymentMethods` to true if your business handles
            // delayed notification payment methods like US bank accounts.
            .allowsDelayedPaymentMethods(true)
            .build()
    )
}
//
//private
//}