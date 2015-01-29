package guice

import com.google.inject.{Guice, Binder, Module}

class DependencyModule extends Module {

  def configure(binder: Binder) = {
    binder.bind(classOf[UserDAOComponent]).to(classOf[UserDAO])

  }
}


object Test extends App {
  val injector = Guice.createInjector(new DependencyModule)
  val component = injector.getInstance(classOf[UserService]) //get UserService object

  // ...
}