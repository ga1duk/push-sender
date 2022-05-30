package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val messageLike = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken(token)
        .build()

    val messageNewPost = Message.builder()
        .putData("action", "NEW_POST")
        .putData("content", """{
          "postAuthor": "Netology",
          "postContent": "Начиная с Android 8.0, все нотификации должны быть присоединены к каналам, иначе они не появятся. Благодаря группировке ваших нотификаций с помощью каналов, пользователь может отключить тот или иной канал (вместо отключения всех нотификаций приложения), а также контролировать визуальное и аудиальное сопровождение каждого канала."
        }""".trimIndent())
        .setToken(token)
        .build()

//    FirebaseMessaging.getInstance().send(messageLike)
    FirebaseMessaging.getInstance().send(messageNewPost)
}
