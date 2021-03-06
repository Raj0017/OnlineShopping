 <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto" id="home">
          <li class="nav-item active">
            <a class="nav-link" href="${contextRoot}/">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item" id="about">
            <a class="nav-link" href="${contextRoot}/about">About Us</a>
          </li>
          <li class="nav-item" id="ListProduct">
            <a class="nav-link" href="${contextRoot}/show/all/products">View Product</a>
          </li>
          <li class="nav-item" id="contact">
            <a class="nav-link" href="${contextRoot}/contact">Contact</a>
          </li>
          <li class="nav-item" id="manageProducts">
            <a class="nav-link" href="${contextRoot}/manage/products">Manage Products</a>
          </li>
        </ul>
        <!-- start for login and signup -->
        <ul class="nav navbar-nav navbar-right">
        
        <li id="register">
          <a href="${contextRoot}/register">Signup</a>
          </li>
        <li id="login ">
          <a href="${contextRoot}/login">Login</a>
        
        </li>
        
        </ul> 
      </div>
    </div>
  </nav>

