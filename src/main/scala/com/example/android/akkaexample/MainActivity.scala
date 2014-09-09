package com.example.android.akkaexample

import org.scaloid.common.SActivity
import android.os.Bundle
import com.exanple.android.akkaexample.R
import SimpleHttpClient._
import android.widget.TextView
import akka.actor.ActorSystem


class MainActivity extends SActivity {

  private implicit val system = ActorSystem("example")

  override def onCreate(savedState: Bundle): Unit = {
    import system.dispatcher
    super.onCreate(savedState)
    setContentView(R.layout.main)

    askServer foreach {
      case serverAnswer: String => runOnUiThread {
        find[TextView](R.id.serverAnswerTextView).setText(s"server answered: ${serverAnswer}") }
    }
  }

}
