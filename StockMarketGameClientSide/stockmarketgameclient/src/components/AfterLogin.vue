<template>
    <div id="afterLogin">
        <div class="login-container">
        <div class="d-flex align-items-center justify-content-center bg-br-primary ht-100v">
            <div class="login-wrapper wd-300 wd-xs-350 pd-25 pd-xs-40 bg-white rounded shadow-base">
                <div v-if="!isStartGame">
                    <button type="button" class="btn btn-info btn-block btn-lg" @click="startGame"><i class="fa fa-hourglass-start"></i> Start Game</button>
                    <button type="button" class="btn btn-info btn-block btn-lg"><i class="fa fa-eye"></i> View Profile</button>
                </div>
                <div v-else>
                    
                </div>
                
                
            </div>
        </div>

    </div>
    </div>
</template>

<script>
const GAME_START = 1,
  GAME_NOTSTART = 0;

  import axios from 'axios';
  import apiUrl from '@/assets/common';

export default {
  data() {
    return {
      afterLoginStatus: null,
      bankList: []
    };
  },
  methods: {
    startGame() {
      //this.afterLoginStatus = GAME_START;
      this.loadBankList();
    },
    reset() {
      this.afterLoginStatus = GAME_NOTSTART;
    },
    loadBankList() {
        axios.create({
  baseURL: apiUrl,
  timeout: 1000,
  headers: {'Accept': 'application/json'}
});
      axios
        .get(apiUrl + "/Bank/GetAllBanks/")
        .then(function(response) {
          console.log(response);
        })
        .catch(function(error) {
          console.log(error);
        });
    }
  },
  computed: {
    isStartGame() {
      return this.afterLoginStatus === GAME_START;
    }
  },
  mounted() {
    this.reset();
    this.loadBankList();
  }
};
</script>



