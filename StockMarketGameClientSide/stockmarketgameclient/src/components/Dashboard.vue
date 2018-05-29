<template>
<div id="Dashboard">
<!-- ########## START: MAIN PANEL ########## -->
      <div class="br-pageheader pd-y-15 pd-l-20">
        <nav class="breadcrumb pd-0 mg-0 tx-12">
          <a class="breadcrumb-item">Game Borad</a>
        </nav>
      </div><!-- br-pageheader -->
      <div class="pd-x-20 pd-sm-x-30 pd-t-20 pd-sm-t-30">
        <h4 class="tx-gray-800 mg-b-5">Popup of Analyst</h4>
      </div>

      <div class="br-pagebody pd-x-20 pd-sm-x-30 pd-b-20">
        <div class="row mg-b-20">            
            <div class="col-md mg-t-20 mg-md-t-0">
              <div class="card card-body bg-dark tx-white bd-0">
                <div align="center">
                  <label class="sidebar-label pd-x-25">Time &amp; Date</label>
                  <div class="pd-x-25">
                    <h2 id="brTime" class="tx-white tx-lato mg-b-5"></h2>
                    <h6 id="brDate" class="tx-white tx-light op-3"></h6>
                  </div>  
                </div>              
              </div><!-- card -->
            </div><!-- col -->
          </div><!-- row -->

        <div class="row row-sm mg-t-20">
          <div class="col-sm-6 col-lg-2">
            <div class="card shadow-base bd-0">
              <div class="card-header bg-transparent d-flex justify-content-between align-items-center">
                <h6 class="card-title tx-uppercase tx-12 mg-b-0">Game Detail</h6>
              </div><!-- card-header -->
              <div class="card-body">
                <div class="card">
                <div class="card-header tx-medium">
                  Bank Balance
                </div><!-- card-header -->
                <div class="card-body">
                  <label>Rs. 1000.00</label>
                </div><!-- card-body -->
              </div><!-- card -->
              <br />
              <div class="card">
                <div class="card-header tx-medium">
                  Round
                </div><!-- card-header -->
                <div class="card-body">
                  <label>1</label>
                </div><!-- card-body -->
              </div><!-- card -->
              <br />
              <div class="card">
                <div class="card-header tx-medium">
                  Highest Score
                </div><!-- card-header -->
                <div class="card-body">
                  <label>1200</label>
                </div><!-- card-body -->
              </div><!-- card -->  
              <br />
              <div class="card">
                <div class="card-header tx-medium">
                  My Score
                </div><!-- card-header -->
                <div class="card-body">
                  <label>2000</label>
                </div><!-- card-body -->
              </div><!-- card -->    

              </div><!-- card-body -->
            </div><!-- card -->
          </div><!-- col-4 -->
          <div class="col-sm-6 col-lg-7 mg-t-20 mg-sm-t-0">
            <div class="card shadow-base bd-0">
              <div class="card-header bg-transparent d-flex justify-content-between align-items-center">
                <h6 class="card-title tx-uppercase tx-12 mg-b-0">Watch List</h6>
              </div><!-- card-header -->
              <div class="card-body">
                
              </div><!-- card-body -->

              <div class="card-header bg-transparent d-flex justify-content-between align-items-center">
                <h6 class="card-title tx-uppercase tx-12 mg-b-0">My Shares</h6>
              </div><!-- card-header -->
              <div class="card-body">
                
              </div><!-- card-body -->
            </div><!-- card -->
          </div><!-- col-4 -->
          <div class="col-sm-6 col-lg-3 mg-t-20 mg-lg-t-0">
            <div class="card shadow-base bd-0">
              <div class="card-header bg-transparent d-flex justify-content-between align-items-center">
                <h6 class="card-title tx-uppercase tx-12 mg-b-0">Share Prices</h6>
              </div><!-- card-header -->
              <div class="card-body">
                
              </div><!-- card-body -->
            </div><!-- card -->
          </div><!-- col-4 -->
        </div><!-- row -->

      </div><!-- br-pagebody -->

    <!-- ########## END: MAIN PANEL ########## -->
<!--
<div class="tab-pane pos-absolute a-0 mg-t-60 overflow-y-auto" id="calendar" role="tabpanel">
          <label class="sidebar-label pd-x-25 mg-t-25">Time &amp; Date</label>
          <div class="pd-x-25">
            <h2 id="brTime" class="tx-white tx-lato mg-b-5"></h2>
            <h6 id="brDate" class="tx-white tx-light op-3"></h6>
          </div>      
          
        </div>-->

</div>


</template>

<script>
import msg from "@/components/HelloWorld";
import msg2 from "@/components/HelloWorld";

export default {
  name: "Dashboard",
  components: { msg, msg2 }
};
</script>