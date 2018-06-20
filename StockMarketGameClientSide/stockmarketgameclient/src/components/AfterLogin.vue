<template>
<div>
    <div id="afterLogin" v-if="!isDashboardShow">
        <div class="login-container">
        <div class="d-flex align-items-center justify-content-center bg-br-primary ht-100v">
            <div class="login-wrapper wd-300 wd-xs-350 pd-25 pd-xs-40 bg-white rounded shadow-base" id="tset">
                <div v-if="!isStartGame">
                    <button type="button" class="btn btn-info btn-block btn-lg" @click="startGame"><i class="fa fa-hourglass-start"></i> Start Game</button>
                    <button type="button" class="btn btn-info btn-block btn-lg"><i class="fa fa-eye"></i> View Profile</button>
                </div>
                <div v-else>
                    <select class="form-control" v-model="bankId">
                    <option value="0">Choose Bank</option>
                    <option v-for="bank in bankList" v-bind:key="bank.id" :value="bank.id">{{bank.name}}</option>
                </select>
                <small v-show="isSubmitted && !bankId != 0" class="tx-danger">Bank Required</small>
                <br/>
                <select class="form-control" v-model="brokerId">
                    <option value="0">Choose Broker</option>
                    <option v-for="broker in brokerList" v-bind:key="broker.id" :value="broker.id">{{broker.name}}</option>
                </select>
                <small v-show="isSubmitted && !brokerId != 0" class="tx-danger">Broker Required</small>
                <br />
                <button type="button" class="btn btn-info btn-block btn-lg" @click="goGame"><i class="fa fa-arrow-right"></i> Start</button>
                </div>
                
                
                
            </div>
        </div>

    </div>
    </div>
    <Layout v-if="isDashboardShow"></Layout>
    </div>
</template>

<script>
const GAME_START = 1,
  GAME_NOTSTART = 0,
  DASHBOARD_SHOW = 2;

import axios from "axios";
import apiUrl from "@/assets/common";
import Vue from "vue";
import Layout from "@/components/Layout";

export default {
  components: { Layout },
  data() {
    return {
      afterLoginStatus: null,
      bankList: [],
      brokerList: [],
      bankId: 0,
      brokerId: 0,
      game: {
        id: "",
        bankId: "",
        brokerId: "",
        playerId: "",
        bankBalance: ""
      },
      isDashboard: null,
      isSubmitted: false
    };
  },
  methods: {
    startGame() {
      this.afterLoginStatus = GAME_START;
    },
    reset() {
      this.afterLoginStatus = GAME_NOTSTART;
      this.isDashboard = GAME_NOTSTART;
    },
    loadBankList() {
      axios
        .get(apiUrl + "/Bank/GetAllBanks/")
        .then(
          function(response) {
            this.bankList = response.data;
          }.bind(this)
        )
        .catch(function(error) {
          console.log(error);
        });
    },
    loadBrokers() {
      axios
        .get(apiUrl + "/Broker/GetAllBrokers/")
        .then(
          function(response) {
            this.brokerList = response.data;
          }.bind(this)
        )
        .catch(function(error) {
          console.log(error);
        });
    },
    goGame() {
        this.isSubmitted = true;
      if (this.bankId && this.brokerId) {
          this.isSubmitted = false;
        this.isDashboard = DASHBOARD_SHOW;
        this.$router.push("/dashboard");
      }
    }
  },
  computed: {
    isStartGame() {
      return this.afterLoginStatus === GAME_START;
    },
    isDashboardShow() {
      return this.isDashboard === DASHBOARD_SHOW;
    }
  },
  mounted() {
    this.reset();
  },
  created() {
    axios.create({
      baseURL: apiUrl,
      timeout: 1000,
      headers: { Accept: "application/json" }
    });

    this.loadBankList();
    this.loadBrokers();
  }
};
</script>



