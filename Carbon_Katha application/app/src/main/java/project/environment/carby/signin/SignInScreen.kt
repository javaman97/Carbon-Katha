//import android.content.Intent
//import android.widget.Toast
//import androidx.activity.compose.ManagedActivityResultLauncher
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.ActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import com.google.android.gms.auth.api.signin.GoogleSignIn
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions
//import com.google.android.gms.common.api.ApiException
//import com.google.firebase.Firebase
//import com.google.firebase.auth.AuthResult
//import com.google.firebase.auth.GoogleAuthProvider
//import com.google.firebase.auth.auth
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.tasks.await
//import project.environment.carby.R
//import project.environment.carby.navigation.Screens
//import project.environment.carby.signin.SignInState
//import kotlin.text.Typography.registered
//
//
//@Composable
//fun SignInScreen(
//    navController: NavController
//) {
//    val token = stringResource(R.string.web_client_Id)
//    var user by remember { mutableStateOf(Firebase.auth.currentUser) }
//    val context = LocalContext.current
//    val gso =
//        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(token)
//            .requestEmail().requestProfile()
//            .build()
//    val googleSignInClient = GoogleSignIn.getClient(context, gso)
//    val launcher = rememberFirebaseAuthLauncher(
//        onAuthComplete = { result ->
//            user = result.user
//            println("hiiii and $user")
//        },
//        onAuthError = {
//            user = null
//            println("hiiii and $it")
//        }
//    )
////    LaunchedEffect(key1 = state.signInError) {
////        state.signInError?.let { error ->
////            Toast.makeText(
////                context,
////                error,
////                Toast.LENGTH_LONG
////            ).show()
////        }
////    }
//    LaunchedEffect(key1 = user) {
//        println("hiiokkjvfgf $user ")
//        if (user != null) {
////                val registered = profileList?.any { it.email == user?.email }
//
////                coroutineScope.launch {
////                    dataStore.saveEmail(user?.email.toString())
////                    dataStore.savePfp(user?.photoUrl.toString())
////                    dataStore.saveName(user?.displayName.toString())
////                }
//            navController.popBackStack()
//            navController.navigate(
//                    Screens.MainHomeScreen.route
//            )
//
//        }
//    }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        contentAlignment = Alignment.Center
//    ) {
//        Button(onClick = {  launcher.launch(googleSignInClient.signInIntent)}) {
//            Text(text = "Sign in")
//        }
//    }
//}
//
//
//@Composable
//fun rememberFirebaseAuthLauncher(
//    onAuthComplete: (AuthResult) -> Unit,
//    onAuthError: (ApiException) -> Unit
//): ManagedActivityResultLauncher<Intent, ActivityResult> {
//    val scope = rememberCoroutineScope()
//    return rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//        try {
//            val account = task.getResult(ApiException::class.java)!!
//            val credential = GoogleAuthProvider.getCredential(account.idToken!!, null)
//            scope.launch {
//                val authResult = Firebase.auth.signInWithCredential(credential).await()
//                onAuthComplete(authResult)
//            }
//        } catch (e: ApiException) {
//            onAuthError(e)
//        }
//    }
//}