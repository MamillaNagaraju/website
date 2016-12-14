<%@include file="header.jsp" %>

   <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 50%;
      margin: auto;
  }
  </style>


<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
        <img src="resources/images/pumaimage.jpg" alt="Puma" width="160" height="145">
        <div class="carousel-caption">
          <h1>Puma Shoes</h1>
                  </div>
      </div>

      <div class="item">
        <img src="resources/images/img1.jpg" alt="img1" width="160" height="145">
        
      </div>
    
      <div class="item">
        <img src="resources/images/img3.jpg" alt="img2" width="160" height="145">
        
      </div>

      <div class="item">
        <img src="resources/images/img4.jpg" alt="Flower" width="160" height="145">
        
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<%@include file="CommonFooter.jsp" %>