package com.example.android.akkaexample

import spray.client.pipelining._
import scala.concurrent.Future
import akka.actor.ActorSystem
import spray.http.HttpResponse


object SimpleHttpClient {

  def askServer(implicit system: ActorSystem): Future[String] = {
    import system.dispatcher

    val pipeline = sendReceive

    pipeline {
      Get("http://httpbin.org/get")
    } map {
      case response: HttpResponse => {
        response.entity.asString
      }
    }
  }

}
