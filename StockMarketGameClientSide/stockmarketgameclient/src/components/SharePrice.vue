<template>
    <div>
        <div class="br-pageheader pd-y-15 pd-l-20">
        <nav class="breadcrumb pd-0 mg-0 tx-12">
          <a class="breadcrumb-item">Share</a>
        </nav>
      </div>
      <div class="pd-x-20 pd-sm-x-30 pd-t-20 pd-sm-t-30">
        <h4 class="tx-gray-800 mg-b-5">Share Prices</h4>
      </div>

      <div class="br-pagebody pd-x-20 pd-sm-x-30 pd-b-20">
          <div class="row row-sm mg-t-20">
              <div class="col-lg-12">
            <div class="card shadow-base bd-0">
              <div class="card-header bg-transparent pd-20">
                <h6 class="card-title tx-uppercase tx-12 mg-b-0">Company Share Prices</h6>
              </div><!-- card-header -->
              <table class="table table-responsive mg-b-0 tx-12">
                <thead>
                  <tr class="tx-10">
                    <th class="wd-10p pd-y-5">&nbsp;</th>
                    <th class="pd-y-5">Compnay Name</th>
                    <th class="pd-y-5">No Of Shares</th>
                    <th class="pd-y-5">Share Price</th>
                    <th class="pd-y-5">Action</th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="price in sharePriceList" v-bind:key="price.id">
                    <td class="pd-l-20">
                      <img src="http://via.placeholder.com/280x280" class="wd-36 rounded-circle" alt="Image">
                    </td>
                    <td>
                      <a href="" class="tx-inverse tx-14 tx-medium d-block">{{price.name}}</a>
                      <span class="tx-11 d-block"></span>
                    </td>
                    <td class="tx-12">
                      <span class="square-8 bg-success mg-r-5 rounded-circle"></span> {{price.noOFShares}}
                    </td>
                    <td>Rs. {{price.shareValue}}</td>
                    <td>
                        <button class="btn btn-info btn-icon" @click="addtoWatchList(price)" data-toggle="tooltip" data-placement="top" title="Add Watch list"><div><i class="fa fa-eye"></i></div></button>
                        <button class="btn btn-info btn-icon" data-toggle="tooltip" data-placement="top" title="Purchase"><div><i class="fa fa-cart-plus"></i></div></button>
                    </td>
                  </tr>
                  
                  
                  
                  
                </tbody>
              </table>
              <div class="card-footer tx-12 pd-y-15 bg-transparent">
                <b-alert :variant="alert.isError ?'danger':'success' " :show="alert.show"
                >
                {{alert.message}}                
                </b-alert>
              </div><!-- card-footer -->
            </div><!-- card -->
          </div>
          

          </div>

      </div>

    </div>
</template>

<script>
import axios from "axios";
import apiUrl from "@/assets/common";

export default {
  data() {
    return {
      sharePriceList: [],
      alert: {
        show: false,
        message: "",
        isError: false
      }
    };
  },
  methods: {
    getAllSharePriceList() {
      axios
        .get(
          apiUrl +
            "/Game/GetAllCompanies/" +
            localStorage.getItem("gameRoundId")
        )
        .then(
          function(response) {
            this.sharePriceList = response.data;
          }.bind(this)
        )
        .catch(function(error) {
          console.log(error);
        });
    },
    addtoWatchList(price) {
      var watchObj = JSON.parse(JSON.stringify(price));
      watchObj.gamePlayerId = localStorage.getItem("gamePlayerId");

      axios
        .post(apiUrl + "/Game/CreateWatch", {
          id: watchObj.id,
          gamePlayerId: watchObj.gamePlayerId,
          name: watchObj.name,
          noOFShares: watchObj.noOFShares,
          shareValue: watchObj.shareValue
        })
        .then(
          function(response) {
            this.alert.show = true;
            this.alert.message = "Successfully Added to watch list";
            this.alert.isError = false;
          }.bind(this)
        )
        .catch(function(error) {
          this.alert.isError = true;
          this.alert.show = true;
          this.alert.message = "Error has occurred.";
          console.log(error);
        });

      setTimeout(function() {
        this.alert.show = false;
      }.bind(this), 4000);
    }
  },
  mounted() {
    this.getAllSharePriceList();
  }
};
</script>
