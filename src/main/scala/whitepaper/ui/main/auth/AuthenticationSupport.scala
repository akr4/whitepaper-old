package whitepaper.ui.main.auth

import org.scalatra.ScalatraKernel
import org.scalatra.auth.strategy.{BasicAuthSupport, BasicAuthStrategy}
import org.scalatra.auth.{ScentryConfig, ScentrySupport}

case class MyUser(id: String)

class OurBasicAuthStrategy(protected override val app: ScalatraKernel, realm: String)
  extends BasicAuthStrategy[MyUser](app, realm) {

  protected def validate(userName: String, password: String): Option[MyUser] = {
    if(userName == "scalatra" && password == "scalatra") Some(MyUser("scalatra"))
    else None
  }

  protected def getUserId(user: MyUser): String = user.id
}

trait AuthenticationSupport extends ScentrySupport[MyUser] with BasicAuthSupport[MyUser] { self: ScalatraKernel =>

  val realm = "Scalatra Basic Auth Example"
  protected def contextPath = request.getContextPath

  protected def fromSession = { case id: String => MyUser(id)  }
  protected def toSession   = { case usr: MyUser => usr.id }

  protected val scentryConfig = (new ScentryConfig {}).asInstanceOf[ScentryConfiguration]


  override protected def configureScentry = {
    scentry.unauthenticated {
      scentry.strategies('Basic).unauthenticated()
    }
  }

  override protected def registerAuthStrategies = {

    scentry.registerStrategy('Basic, app => new OurBasicAuthStrategy(app, realm))
  }

}
