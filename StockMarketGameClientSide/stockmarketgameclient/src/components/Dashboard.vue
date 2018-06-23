<template>
<div id="Dashboard">
      <div class="br-pageheader pd-y-15 pd-l-20">
        <nav class="breadcrumb pd-0 mg-0 tx-12">
          <a class="breadcrumb-item">Game Borad</a>
        </nav>
      </div>
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
              </div>
            </div>
          </div>

        <div class="row row-sm mg-t-20">
          <div class="col-sm-6 col-lg-2">
            <div class="card shadow-base bd-0">
              <div class="card-header bg-transparent d-flex justify-content-between align-items-center">
                <h6 class="card-title tx-uppercase tx-12 mg-b-0">Game Detail</h6>
              </div>
              <div class="card-body">
                <div class="card">
                <div class="card-header tx-medium">
                  Bank Balance
                </div>
                <div class="card-body">
                  <label>Rs. 1000.00</label>
                </div>
              </div>
              <br />
              <div class="card">
                <div class="card-header tx-medium">
                  Round
                </div>
                <div class="card-body">
                  <label>1</label>
                </div>
              </div>
              <br />
              <div class="card">
                <div class="card-header tx-medium">
                  Highest Score
                </div>
                <div class="card-body">
                  <label>1200</label>
                </div>
              </div>
              <br />
              <div class="card">
                <div class="card-header tx-medium">
                  My Score
                </div>
                <div class="card-body">
                  <label>2000</label>
                </div>
              </div>

              </div>
            </div>
          </div>
          <div class="col-sm-6 col-lg-7 mg-t-20 mg-sm-t-0">
            <div class="card shadow-base bd-0">
              <div class="card-header bg-transparent d-flex justify-content-between align-items-center">
                <h6 class="card-title tx-uppercase tx-12 mg-b-0">Watch List</h6>
              </div>
              <div class="card-body">
                
              </div>

              <div class="card-header bg-transparent d-flex justify-content-between align-items-center">
                <h6 class="card-title tx-uppercase tx-12 mg-b-0">My Shares</h6>
              </div>
              <div class="card-body">
                
              </div>
            </div>
          </div>
          <div class="col-sm-6 col-lg-3 mg-t-20 mg-lg-t-0">
            <div class="card shadow-base bd-0">
              <div class="card-header bg-transparent d-flex justify-content-between align-items-center">
                <h6 class="card-title tx-uppercase tx-12 mg-b-0">Share Prices</h6>
              </div>
              <div class="card-body">
                
              </div>
            </div>
          </div>
        </div>
      </div>
</div>


</template>

<script>
import axios from "axios";
import apiUrl from "@/assets/common";

export default {
  name: "Dashboard",
  data(){
    return{

    };
  },
  methods:{

  },
  mounted(){

  },
  computed:{

  }
};
</script>