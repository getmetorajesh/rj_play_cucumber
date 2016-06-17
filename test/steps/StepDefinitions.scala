package features.steps

import cucumber.api.PendingException
import cucumber.api.scala.{EN, ScalaDsl}
import cucumber.api.DataTable
import org.scalatest.Matchers

import play.api.test._
import play.api._
import play.api.mvc._
import play.api.Play.current
import org.openqa.selenium._
import org.fluentlenium.core.filter.FilterConstructor._


class StepDefinitions extends ScalaDsl with EN with Matchers {

  val webDriverClass = Helpers.HTMLUNIT

  val app = FakeApplication()
  val port = 3333

  lazy val browser: TestBrowser = TestBrowser.of(webDriverClass, Some("http://localhost:" + port))
  lazy val server = TestServer(port, app)

  def driver = browser.getDriver()

  Before() { s =>
    server.start()
  }

  After() { s =>
    server.stop()
    browser.quit()
  }

  Given("""^my application running$"""){ () =>
    //// Write code here that turns the phrase above into concrete actions
    Logger.debug("Yes app is running")
  }
  When("""^I go to the "([^"]*)" page$"""){ (pageName:String) =>
    var pageUrl = pageName match {
      case "start" => controllers.routes.HomeController.index.url
      case _ => throw new RuntimeException(s"Unsupported page: $pageName")
    }
  }
  Then("""^I should see "([^"]*)"$"""){ (expectedText:String) =>
    //// Write code here that turns the phrase above into concrete actions
    println("************ LAST TEST ************")
    println(browser.find("body").toString)
    println("************ LAST TEST ************")
    val element = browser.find("body", withText().contains(expectedText))

    withClue("Expected text not found in body: " + expectedText) {
      element shouldNot be(empty)
    }
  }


  Given("""^the page is countcontroller$"""){ () =>
    //// Write code here that turns the phrase above into concrete actions
    Logger.debug("Count controller")
  }
  When("""^I visit the "([^"]*)" page$"""){ (arg0:String) =>
    //// Write code here that turns the phrase above into concrete actions
    throw new PendingException()
  }
  Then("""^I should see count$"""){ () =>
    //// Write code here that turns the phrase above into concrete actions
    throw new PendingException()
  }

}