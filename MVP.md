MVP : architectural pattern design derived from MVC and used for building user interfaces

Separation of concerns: model, view and presenter

Model: data + state + business logic of the application.
	   Independent. Reusable.

View: its our activity/fragment
	  event happens -> View calls method from presenting

Presenter: located between model and view.
		   all logical task is done here.
		   tells the view what to display calling view method.

--To make this work without tying the view to the presenter
we create an interface that the Activity/fragment implements

--The presenter also implements and interface. 
And this is beacause a Contract interface defines the interaction
between the View and the Presenter.

--Another reason is that we dont want the presenter
either any other entity to depend upon concretions but upon abstractions ('D' of SOLID pattern)
this means we are decoupling objects and introducing dependency inversion.

--We can easily unit test the presenter logic because it’s not tied to any Android specific views and APIs and that also allows us to work with any other view as long as the view implements the specific interface. 