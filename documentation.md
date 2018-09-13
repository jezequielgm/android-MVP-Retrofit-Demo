MainContract.java interface

	Three inner interfaces

	MainView	interface callback will be called when the uer needs to show/hide progress bar
				set data to recycler vie
				show error if network response failed

	Intractor	fetches data source(RESTful web service)
				has nested inteface onFinishedListener(abstraction cannot be accessed directly)
					called once we get response
					or get error

	Presenter 	called when requesting data from server for the first time
				and when the view is destroyed.

IntractorImpl.java implements MainContract.Intractor

	Responsible of getting data using the rest apis using retrofit library
	and of passing that data tohrough onFinishedListener callback

	Retrofit object generation. Use that object for getting a Call object for invoking enqueue method
	That method implements an interface of type Callback. If everything goes fine we will get our
	response inside onResponse implemented method and we will pass it through onFinish callback

MainPresenterImpl.java implements MainContract.Intractor.OnFinishedListener, MainContract.Presenter

	This class receives request from the view and then tells the View what to display
	Receive data from the model.

	When onDestroy overriden method from the view is called then onDestroy callback is called 
	and the view is set to null

	When requestFromData is called from the view then the method getMarsFromActivity() is called here
	and start getting data from the webservice.

	onFinished and onFailure callbacks are called from IntractorImpl.java

RecyclerItemClickListener.java Interface

	Listens to the onItemClick callback from the recycler view list

	In the view there's an object of type RecyclerItemClickListener, this interface,
	that implements it.

	Later, we pass that object as an input parameter of MarsPhotosAdapter's constructor
	using that implementation inside the overriden method onBindViewHolder.

MarsPhotosAdapter.java extends RecyclerView.Adapter<MarsPhotosAdapter.MarsPhotosViewHolder>

	Displays the list of MarsPhotos objects in the recycler view.

	In the overriden method onBindViewHolder we use Picasso library for caching retrieving photos
	and we have defined the onClickListener.

	Internal class MarsPhotosViewHolder that extends RecyclerView.ViewHolder is used to reference
	widgets from the custom view. An object of it is created in the return statement of the overriden method onCreateViewHolder where layout inflation takes place.

MainActivity.java implements MainContract.MainView

	this class calls the corresponding presenter method when the view is created or when an event happens