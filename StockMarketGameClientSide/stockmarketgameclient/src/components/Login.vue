<template>
    <div id="login">
    <div id="auxxaLogin" class="login-container">
        <div class="d-flex align-items-center justify-content-center bg-br-primary ht-100v">
            <div class="login-wrapper wd-300 wd-xs-350 pd-25 pd-xs-40 bg-white rounded shadow-base">
                <div class="text-center"><img src="" width="50%" /></div>
                <div class="signin-logo tx-center tx-28 tx-bold tx-inverse mg-b-10"><span class="tx-normal">[</span> Auxxa - Suite 1.0 <span class="tx-normal">]</span></div>

                <div id="alertWithIcon" style="display:none;">
                    <div class="alert alert-danger" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <div class="d-flex align-items-center justify-content-start">
                            <span><strong id="msg"></strong></span>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <input type="text" class="form-control input-login" id="userName" v-model="userModel.userName" placeholder="Enter Username">
                    <!--<small v-show="isSubmitted && !userModel.userName" class="tx-danger">User Name is Required</small>-->
                </div><!-- form-group -->
                <div class="form-group">
                    <input type="password" class="form-control input-login" id="pin" v-model="userModel.password" placeholder="Enter Password" v-on:keyup.enter="login">
                    <!--<small v-show="isSubmitted && !userModel.password" class="tx-danger">User Name is Required</small>-->
                    
                </div><!-- form-group -->
                <button v-on:click="login" id="Login" type="submit" class="btn btn-primary active  btn-block mg-b-10">  Log me in</button>

            </div><!-- login-wrapper -->
        </div><!-- d-flex -->

    </div>
    </div>

</template>

<script>

export default {
    name: 'Login',   
    methods:{
        login: function(){
            this.$router.push('/test');
        }

    },
    data(){
        return{
            userModel:{
            userName:'',
            password:''
        }

        }
    }    
}

</script>