<template>
<div id="layout">
    <div class="br-logo">
        <a href="#">
            <span>[</span>Code Chef
            <span>]</span>
        </a>
    </div>
    <div class="br-sideleft overflow-y-auto ps ps--theme_default ps--active-x ps--active-y" id="navigation">
        <label class="sidebar-label pd-x-15 mg-t-20">Navigation</label>
        <div class="br-sideleft-menu">
            <a href="#" class="br-menu-link active">
                <div class="br-menu-item">
                    <i class="menu-item-icon icon ion-ios-home-outline tx-22"></i>
                    <span class="menu-item-label">
                        <router-link to="/dashboard">
                            <a>Game Borad</a>
                        </router-link>
                    </span>
                </div>
            </a>
            
            <a href="#" class="br-menu-link">
                <div class="br-menu-item">
                    <i class="menu-item-icon icon ion-ios-briefcase tx-22"></i>
                    <span class="menu-item-label">
                        <router-link to="/share">
                            <a>My Shares</a>
                        </router-link>                        
                    </span>
                </div>
            </a>
            <a href="#" class="br-menu-link">
                <div class="br-menu-item">
                    <i class="menu-item-icon icon ion-cash tx-22"></i>
                    <span class="menu-item-label">
                        <router-link to="/shareprice">
                            <a>Share Price</a>
                        </router-link> 
                        
                    </span>
                </div>
            </a>
            <a href="#" class="br-menu-link">
                <div class="br-menu-item">
                    <i class="menu-item-icon icon ion-ios-eye tx-22"></i>
                    <span class="menu-item-label">
                        <router-link to="/watch">
                            <a>Watch List</a>
                        </router-link>
                        
                        
                    </span>
                </div>
            </a>
            <a href="#" class="br-menu-link">
                <div class="br-menu-item">
                    <i class="menu-item-icon icon ion-ios-cart-outline tx-22"></i>
                    <span class="menu-item-label">
                        <router-link to="/purchasehistory">
                            <a>Purchase History</a>
                        </router-link> 
                        
                    </span>
                </div>
            </a>
            <a href="#" class="br-menu-link">
                <div class="br-menu-item">
                    <i class="menu-item-icon icon ion-clipboard tx-22"></i>
                    <span class="menu-item-label">
                        <router-link to="/transactionhistory">
                            <a>Transaction History</a>
                        </router-link>
                        
                    </span>
                </div>
            </a>

            <!-- <a href="#" class="br-menu-link">
                <div class="br-menu-item">
                    <i class="menu-item-icon icon ion-ios-undo tx-22"></i>
                    <span class="menu-item-label">
                        <router-link to="/previousround">
                            <a>Previous Round</a>
                        </router-link>
                        
                    </span>
                </div>
            </a> -->

            <a href="#" class="br-menu-link">
                <div class="br-menu-item">
                    <i class="menu-item-icon icon ion-ios-people tx-22"></i>
                    <span class="menu-item-label">
                        <router-link to="/allplayers">
                            <a>Other Player</a>
                        </router-link>
                        
                    </span>
                </div>
            </a>
            <!--Start Menu-->
           
            <!--End Menu-->
        </div>
        <br>
    </div>
    <!-- ########## END: LEFT PANEL ########## -->
    <!-- ########## START: HEAD PANEL ########## -->
    <div class="br-header">
        <div class="br-header-left">
            <div class="navicon-left hidden-md-down">
                <a id="btnLeftMenu" href="#">
                    <i class="icon ion-navicon-round"></i>
                </a>
            </div>
            <div class="navicon-left hidden-lg-up">
                <a id="btnLeftMenuMobile" href="#">
                    <i class="icon ion-navicon-round"></i>
                </a>
            </div>           
        </div>
        <div class="br-header-right" id="headerBar">
            <nav class="nav">
                <div class="dropdown">
                    <a href="" class="nav-link nav-link-profile" data-toggle="dropdown">
                        <span class="logged-name hidden-md-down"></span>
                        <img src="http://via.placeholder.com/64x64" class="wd-32 rounded-circle" alt="">
                        <span class="square-10 bg-success"></span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-header wd-200">
                        <ul class="list-unstyled user-profile-nav">
                            
                            <li @click="signOut">
                                <a href="#">
                                    <i class="icon ion-power"></i> Sign Out
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>           
        </div>
    </div>
    <!-- ########## END: HEAD PANEL ########## -->
    <!-- ########## START: MAIN PANEL ########## -->
    <div class="br-mainpanel">
        <router-view></router-view>
        <footer class="br-footer">
                <div class="footer-left">
                </div>
                <div class="footer-right d-flex align-items-center">
                <div class="mg-b-2">Copyright &copy; 2018. CodeChef. All Rights Reserved.</div>
            </div>
        </footer>
    </div>
</div>
</template>

<script>
export default {
  name: "Layout",
  methods: {
      signOut(){
          location.reload();
      }
  }
};
</script>


