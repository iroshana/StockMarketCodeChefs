<template>
<div id="Dashboard">
      <div class="br-pageheader pd-y-15 pd-l-20">
        <nav class="breadcrumb pd-0 mg-0 tx-12">
          <a class="breadcrumb-item">Game Borad</a>
        </nav>
      </div>
      
      <div class="br-pagebody pd-x-20 pd-sm-x-30 pd-b-20">
        <div class="row mg-b-20">            
            <div class="col-md mg-t-20 mg-md-t-0">
              <div class="card card-body bg-dark tx-white bd-0">
                <div align="center">
                  <div class="pd-x-25">
                    <h2 id="time" class="tx-white tx-lato mg-b-5">1:00</h2>
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
                  <label v-cloak>Rs. {{gamePlayerDetails.bankBalance.toFixed(2)}}</label>
                </div>
              </div>
              <br />
              <div class="card">
                <div class="card-header tx-medium">
                  Round
                </div>
                <div class="card-body">
                  <label v-cloak>{{gamePlayerDetails.round}}</label>
                </div>
              </div>
              <br />
              <div class="card">
                <div class="card-header tx-medium">
                  Total Purchase
                </div>
                <div class="card-body">
                  <label v-cloak>{{gamePlayerDetails.totalPurchase.toFixed(2)}}</label>
                </div>
              </div>
              <br />
              <div class="card">
                <div class="card-header tx-medium">
                  Round Winner
                </div>
                <div class="card-body">
                  <label v-cloak>{{gamePlayerDetails.gameLeaderName}}</label>
                </div>
              </div>
              <br />
              <div class="card">
                <div class="card-header tx-medium">
                  My Score
                </div>
                <div class="card-body">
                  <label v-cloak>{{gamePlayerDetails.score.toFixed(2)}}</label>
                </div>
              </div>
              <br />
              <div class="card">
                <div class="card-header tx-medium">
                  Broker Name
                </div>
                <div class="card-body">
                  <label v-cloak>{{gamePlayerDetails.brokerName}}</label>
                </div>
              </div>
              <br />
              <div class="card">
                <div class="card-header tx-medium">
                  Bank Name
                </div>
                <div class="card-body">
                  <label v-cloak>{{gamePlayerDetails.bankName}}</label>
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
              <div class="table-responsive">
                <table class="table table-bordered table-hover">
                  <thead>
                    <tr>
                      <th>Name</th>
                      <th>No Of Shares</th>
                      <th>Value</th>
                      <th>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="watch in watchList" v-bind:key="watch.id">
                      <td>{{watch.name}}</td>
                      <td>{{watch.noOFShares}}</td>
                      <td>{{watch.shareValue}}</td>
                      <td><button class="btn btn-info btn-icon" @click="showModalPurchase(watch)" data-toggle="tooltip" data-placement="top" title="Purchase"><div><i class="fa fa-cart-plus"></i></div></button></td>
                    </tr>
                  </tbody>
                </table>
              </div>
              </div>

              <div class="card-header bg-transparent d-flex justify-content-between align-items-center">
                <h6 class="card-title tx-uppercase tx-12 mg-b-0">My Shares</h6>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                <table class="table table-bordered table-hover">
                  <thead>
                    <tr>
                      <th>Name</th>
                      <th>No Of Shares</th>
                      <th>Value</th>
                      <th>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="share in shareList" v-bind:key="share.id">
                      <td>{{share.name}}</td>
                      <td>{{share.noOFShares}}</td>
                      <td>{{share.shareValue}}</td>
                      <td><button class="btn btn-info btn-icon" @click="sellShares(share)" data-toggle="tooltip" data-placement="top" title="Sell"><div><i class="icon ion-cash"></i></div></button></td>
                    </tr>
                  </tbody>
                </table>
              </div>
              </div>
            </div>            

          </div>
          <div class="col-sm-6 col-lg-3 mg-t-20 mg-lg-t-0">
            <h6 class="card-title tx-uppercase tx-12 mg-b-0">Share Prices</h6>
            <!-- <div class="card shadow-base bd-0">
              <div class="card-header bg-transparent d-flex justify-content-between align-items-center">
                <h6 class="card-title tx-uppercase tx-12 mg-b-0">Share Prices</h6>
              </div>
              <div class="card-body">
                
              </div>
            </div> -->
            <Chart :idData="chartData" v-if="isdisplay"></Chart>
            <div v-for="lst in sharePriceList" v-bind:key="lst.id">
              <div class="card shadow-base bd-0">
              <div class="card-header bg-transparent d-flex justify-content-between align-items-center">
                <h6 class="card-title tx-uppercase tx-12 mg-b-0">{{lst.name}}</h6>
                <button class="btn btn-info btn-icon" @click="addtoWatchList(lst)" data-toggle="tooltip" data-placement="top" title="Add Watch list"><div><i class="fa fa-eye"></i></div></button>
                <button class="btn btn-info btn-icon" @click="showModal(lst)" data-toggle="tooltip" data-placement="top" title="Purchase"><div><i class="fa fa-cart-plus"></i></div></button>
                <button class="btn btn-info btn-icon" @click="showChartModal(lst)" data-toggle="tooltip" data-placement="top" title="Chart"><div><i class="fa fa-line-chart"></i></div></button>
                <!-- <span class="tx-12 tx-uppercase">June 20, 2017</span> -->
              </div><!-- card-header -->
              <div class="card-body d-xs-flex justify-content-between align-items-center">
                <h4 class="mg-b-0 tx-inverse tx-lato tx-bold">{{lst.noOFShares}}</h4>
                <p class="mg-b-0 tx-sm">Rs. {{lst.shareValue}} </p>
              </div><!-- card-body -->
            </div><!-- card -->
              <br />
            </div>
            
            
          </div>
        </div>
      </div>



      <!-- Modal Component -->
    <b-modal id="modalPrevent"
             ref="myModalRef"
             title="Purchase Shares"
             :hide-footer="true">
             <div class="row no-gutters">
               <b-form @submit="onSubmit" @reset="onReset" v-if="show">

                 <div class="row">
                 <div class="col-md-6">
                   <b-form-group id="exampleInputGroup1"
                    label="Compnay Name:"
                    label-for="exampleInput1"
                    >
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="modalVM.companyName"
                      :readonly="true">
        </b-form-input>
      </b-form-group>
                 </div>
                 <div class="col-md-6">
                   <b-form-group id="exampleInputGroup2"
                    label="No Of Shares:"
                    label-for="exampleInput2">
        <b-form-input id="exampleInput2"
                      type="text"
                      v-model="modalVM.noOfShares"
                      :readonly="true">
        </b-form-input>
      </b-form-group>
                 </div></div>
<div class="row">
                 <div class="col-md-6">
                   <b-form-group id="exampleInputGroup3"
                    label="Share Value:"
                    label-for="exampleInput3">
        <b-form-input id="exampleInput3"
                      type="text"
                      v-model="modalVM.shareValue"
                      :readonly="true">
        </b-form-input>
      </b-form-group>

                 </div>
                 <div class="col-md-6">
                   <b-form-group id="exampleInputGroup4"
                    label="Purchase Value:"
                    label-for="exampleInput4">
        <b-form-input id="exampleInput4"
                      type="text"
                      v-model="modalVM.purchaseQty"                     
                      aria-describedby="inputLiveFeedback"
                      aria-readonly="false">
        </b-form-input>
        <b-form-invalid-feedback id="inputLiveFeedback">
          Invalid Share
    </b-form-invalid-feedback>
      </b-form-group>

                 </div></div>
            
      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Close</b-button>
    </b-form>
               
             </div>
      
    </b-modal>

    <!-- Next Round Modal -->
    <b-modal id="modalPrevent"
             ref="complete"
             v-model="isRoundComplete"
             title="Round Complete"
             :hide-footer="true"
             :no-close-on-backdrop="true"
             :no-close-on-esc="true"
             :hide-header="true">

             <div class="row no-gutters">
               <b-button v-if="gamePlayerDetails.round != 0" type="button" @click="nextRound()" class="btn btn-info btn-lg" variant="primary">Next Round</b-button>
               <b-button v-if="gamePlayerDetails.round == 0" type="button" @click="finishGame()" class="btn btn-info btn-lg" variant="primary">Finish</b-button>
               <div class="col-md-12">
                 <span v-if="gamePlayerDetails.isRoundWinner">You are Won this Round</span>
                 <span v-if="gamePlayerDetails.isGameWinner">You are Won the Game</span>
               </div>
             </div>

    </b-modal>

    <!-- Modal Component Sell -->
    <b-modal id="modalPreventSell"
             ref="myModalSell"
             title="Sell Shares"
             :hide-footer="true">
             <div class="row no-gutters">
               <b-form @submit="onSubmitSell" @reset="onReset">

                 <div class="row">
                 <div class="col-md-6">
                   <b-form-group id="exampleInputGroup20"
                    label="Compnay Name:"
                    label-for="exampleInput21"
                    >
        <b-form-input id="exampleInput21"
                      type="text"
                      v-model="modalVM.companyName"
                      :readonly="true">
        </b-form-input>
      </b-form-group>
                 </div>
                 <div class="col-md-6">
                   <b-form-group id="exampleInputGroup22"
                    label="No Of Shares:"
                    label-for="exampleInput22">
        <b-form-input id="exampleInput22"
                      type="text"
                      v-model="modalVM.noOfShares"
                      :readonly="true">
        </b-form-input>
      </b-form-group>
                 </div></div>
<div class="row">
                 <div class="col-md-6">
                   <b-form-group id="exampleInputGroup23"
                    label="Share Value:"
                    label-for="exampleInput23">
        <b-form-input id="exampleInput23"
                      type="text"
                      v-model="modalVM.shareValue"
                      :readonly="true">
        </b-form-input>
      </b-form-group>

                 </div>
                 <div class="col-md-6">
                   <!-- <b-form-group id="exampleInputGroup4"
                    label="Sell Value:"
                    label-for="exampleInput4">
        <b-form-input id="exampleInput4"
                      type="text"
                      v-model="modalVM.purchaseQty"                     
                      aria-describedby="inputLiveFeedback"
                      aria-readonly="false">
        </b-form-input>
        <b-form-invalid-feedback id="inputLiveFeedback">
          Invalid Share
    </b-form-invalid-feedback>
      </b-form-group> -->

                 </div></div>
            
      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Close</b-button>
    </b-form>
               
             </div>
      
    </b-modal>

    <!-- Chart Modal  -->
    <b-modal id="chartModal"
             ref="chartModalRef"
             title=""
             :hide-footer="true"
             :no-close-on-backdrop="true"
             :no-close-on-esc="true"
             >

             

             <div class="row no-gutters">
               <div class="col-xl-12">
                 <Chart :idData="chartData" v-if="isdisplay"></Chart>
              <!-- <div class="bd pd-t-30 pd-b-20 pd-x-20"><canvas id="chartLine1" height="200"></canvas></div> -->
            </div>
             </div>

    </b-modal>


</div>


</template>

<script>
import axios from "axios";
import apiUrl from "@/assets/common";
import Chart from '@/components/Chart';



export default {
  name: "Dashboard",
  components:{Chart},
  data() {
    return { 
      isRoundComplete: false,
      show: true,
      isdisplay: false,
      modalVM: {
        companyName: "",
        noOfShares: "",
        shareValue: "",
        purchaseQty: ""
      },
      gameCompanyList: [],
      gamePlayerDetails: {
        bankName: "",
        brokerName: "",
        bankBalance: 0.0,
        score: 0,
        totalPurchase: 0,
        totalSales: 0,
        playerName: "",
        round: 0,
        playerId: 0,
        isGameWinner: false,
        isRoundWinner: false,
        gameLeaderName: ''
      },
      watchList: [],
      shareList: [],
      sharePriceList: [],
      chartData: [10,20,30,40,50]
    };
  },
  computed: {},
  methods: {
    getAllCompanies() {
      axios
        .get(
          apiUrl +
            "/Game/GetAllCompanies/" +
            localStorage.getItem("gameRoundId")
        )
        .then(
          function(response) {
            this.gameCompanyList = response.data;
          }.bind(this)
        )
        .catch(function(error) {
          console.log(error);
        });
    },
    getGameDetails() {
      axios
        .get(
          apiUrl + "/Game/GetGamePlayer/" + localStorage.getItem("gamePlayerId")
        )
        .then(
          function(response) {
            this.gamePlayerDetails = response.data;
          }.bind(this)
        )
        .catch(function(error) {
          console.log(error);
        });
    },
    getWatchList() {
      axios
        .get(
          apiUrl + "/Game/GetWatchList/" + localStorage.getItem("gamePlayerId")
        )
        .then(
          function(response) {
            this.watchList = response.data;
          }.bind(this)
        )
        .catch(function(error) {
          console.log(error);
        });
    },
    getShareList() {
      axios
        .get(
          apiUrl +
            "/Purchase/GetMyShares/" +
            localStorage.getItem("gamePlayerId")
        )
        .then(
          function(response) {
            this.shareList = response.data;
          }.bind(this)
        )
        .catch(function(error) {
          console.log(error);
        });
    },
    getCompanySharePrices() {
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
    addtoWatchList(watch) {
      var watchObj = JSON.parse(JSON.stringify(watch));
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
            this.getWatchList();
          }.bind(this)
        )
        .catch(function(error) {
          console.log(error);
        });
    },
    showModal(lst) {
      console.log(lst);
      this.modalVM = {
        id: lst.id,
        companyName: lst.name,
        noOfShares: lst.noOFShares,
        shareValue: lst.shareValue,
        purchaseQty: ""
      };

      this.$refs.myModalRef.show();
    },
    onSubmit(evt) {
      evt.preventDefault();

      if (this.modalVM.purchaseQty) {
        let purchase = {};
        purchase.bankId = localStorage.getItem("bankId");
        purchase.gameCompanyId = this.modalVM.id;
        purchase.gamePlayerId = localStorage.getItem("gamePlayerId");
        purchase.gameRoundId = localStorage.getItem("gameRoundId");
        purchase.noOFShares = this.modalVM.purchaseQty;
        purchase.shareValue = this.modalVM.shareValue;

        this.createPurchase(purchase);
      } else {
        return;
      }
    },
    createPurchase(purch) {
      axios
        .post(apiUrl + "/Purchase/CreatePurchase", purch)
        .then(
          function(response) {
            this.$refs.myModalRef.hide();
            this.getShareList();
            this.getCompanySharePrices();
          }.bind(this)
        )
        .catch(function(error) {
          console.log(error);
        });
    },
    onReset(evt) {
      this.$refs.myModalRef.hide();
    },
    startTimer(duration, display) {
      var timer = duration,
        minutes,
        seconds;

      var timeobj = setInterval(function() {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;        

        if (--timer < 0) {
          timer = duration;
        }
        
        if(display.textContent == '00:00'){ 
          clearInterval(timeobj);
          this.completeRound();
        }
        
        if(display.textContent == '00:40' && this.gamePlayerDetails.round > 1){
          this.getGameAnalysis();
        }
        
      }.bind(this), 1000);      
    },
    timerStart() {
      var fiveMinutes = 60 * 1,
      display = document.querySelector("#time");      
      this.startTimer(fiveMinutes, display);      
    },
    completeRound(){
      let completeobj = {};
      completeobj.gameId = localStorage.getItem("gameId");
      completeobj.gamePlayerId = localStorage.getItem("gamePlayerId");
      completeobj.gameRoundId = localStorage.getItem("gameRoundId");
      completeobj.gameRoundPlayerId = localStorage.getItem("gameRoundPlayerId");
      completeobj.roundId = localStorage.getItem("roundId");
      completeobj.roundNo = localStorage.getItem("roundNo");

      axios
        .post(apiUrl + "/Game/CompleteRound", {
          gameId: completeobj.gameId,
          gamePlayerId: completeobj.gamePlayerId,
          gameRoundId: completeobj.gameRoundId,
          gameRoundPlayerId: completeobj.gameRoundPlayerId,
          roundId: completeobj.roundId,
          roundNo: completeobj.roundNo
        })
        .then(
          function(response) {
            //this.$refs.complete.show();
            this.isRoundComplete = true; 
            console.log(response);
            localStorage.setItem("roundNo", response.data.roundNo);
            localStorage.setItem("gameRoundId", response.data.gameRoundId); 
            localStorage.setItem("gameRoundPlayerId", response.data.gameRoundPlayerId);
            
            this.gamePlayerDetails.round = response.data.roundNo;
            this.gamePlayerDetails.gameHighScore = response.data.gameHighScore;
            this.gamePlayerDetails.score = response.data.myRoundScore;
            this.gamePlayerDetails.isGameWinner = response.data.isGameWinner;
            this.gamePlayerDetails.isRoundWinner = response.data.isRoundWinner;
            this.gamePlayerDetails.gameLeaderName = response.data.gameLeaderName;
          }.bind(this)
        )
        .catch(function(error) {
          console.log(error);
        });
    },
    nextRound(){
      //this.$refs.complete.hide();
      this.isRoundComplete = false;
      this.timerStart();
    },
    showModalPurchase(watch){      
      this.modalVM = {
        id: watch.companyId,
        companyName: watch.name,
        noOfShares: watch.noOFShares,
        shareValue: watch.shareValue,
        purchaseQty: ""
      };
      this.$refs.myModalRef.show();
    },
    sellShares(share){
      this.modalVM = {
        id: share.id,
        companyName: share.name,
        noOfShares: share.noOFShares,
        shareValue: share.shareValue,
        purchaseQty: ""        
      };
      this.$refs.myModalSell.show();      
    },
    onSubmitSell(evt){
      evt.preventDefault();

      axios
        .post(apiUrl + "/Purchase/SellMyShares",{
          gameRoundId: localStorage.getItem("gameRoundId"),
          id: this.modalVM.id
        })
        .then(
          function(response) {
            this.$refs.myModalSell.hide(); 
            this.getShareList();
          }.bind(this)
        )
        .catch(function(error) {
          console.log(error);
        });

    },
    showChartModal(lst){
      this.isdisplay = false;
      axios
        .get(apiUrl + "/Company/GetChartData/" + localStorage.getItem("gameId") + "/" + lst.id)
        .then(
          function(response) {
            this.chartData = response.data;
            this.isdisplay = true;
          }.bind(this)
        )
        .catch(function(error) {
          console.log(error);
        });      
    },
    getGameAnalysis(){
      axios
        .get(apiUrl + "/Analyzer/GetGamePlayer/" + localStorage.getItem("gameId"))
        .then(
          function(response) {
            
          }.bind(this)
        )
        .catch(function(error) {
          console.log(error);
        });
    },
    finishGame(){
      location.reload();
    }
  },
  mounted() {
    this.getAllCompanies();
    this.getGameDetails();
    this.getWatchList();
    this.getShareList();
    this.getCompanySharePrices();
    this.timerStart();
  },
  computed: {}
};

</script>