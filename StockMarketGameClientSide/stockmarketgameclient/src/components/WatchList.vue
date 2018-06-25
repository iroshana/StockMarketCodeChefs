<template>
    <div>
        <div class="br-pageheader pd-y-15 pd-l-20">
        <nav class="breadcrumb pd-0 mg-0 tx-12">
          <a class="breadcrumb-item">Watch </a>
        </nav>
      </div>
      <div class="pd-x-20 pd-sm-x-30 pd-t-20 pd-sm-t-30">
        <h4 class="tx-gray-800 mg-b-5">Selected Company</h4>
      </div>

    <div class="br-pagebody pd-x-20 pd-sm-x-30 pd-b-20">
        <div class="br-section-wrapper">
            <div class="row no-gutters">
                <div class="col-md-12">
                    <div class="bd rounded table-responsive">
                        <table id="datatable1" class="table table-bordered table-hover mg-b-0">
                                <thead>
                                    <tr>
                                        <th class="wd-10p">Name</th>
                                        <th class="wd-10p text-center">No Of Shares</th>
                                        <th class="wd-10p text-center">Value</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr v-for="watch in watchList" v-bind:key="watch.id">
                                        <td>{{watch.name}}</td>
                                        <td>{{watch.noOFShares}}</td>
                                        <td class="tx-right">{{watch.shareValue}}</td>
                                    </tr>
                                </tbody>
                            </table>
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
    data(){
        return{
            watchList: []
        };

    },
    methods:{
        getMyWatchList(){
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
        }

    },
    mounted(){
        this.getMyWatchList();
    }
}
</script>

