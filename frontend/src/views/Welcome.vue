<template>
  <v-main>
    <nav-bar :viewType="navbarType" />
    <v-container>
      <v-img
        class="mx-auto" style="margin-top: 150px; margin-bottom: 50px;"
        src="../assets/images/lolbti_logo_2.png"
        height="300"
        width="600"
      />
      <v-row class="pt-5">
        <v-col md="3"></v-col>
        <v-col xs="11" md="5">
          <v-form onsubmit="return false;">
            <v-text-field
              outline
              label="닉네임 검색"
              append-icon="search"
              v-model="summonerName"
              @keydown.enter="searchSummoner"
            ></v-text-field>
          </v-form>
        </v-col>
        <v-col xs="1" md="1" class="pt-5">
          <v-btn class="btncolor" @click="searchSummoner">검색</v-btn>
        </v-col>
        <v-col md="3"></v-col>
      </v-row>
    </v-container>
  </v-main>
</template>

<script>
import NavBar from "../components/NavBar.vue";
import { EventBus } from "../main.js";
import userApi from "../api/UserApi.js";

export default {
  data() {
    return {
      summonerName: "",
      searchType: 1,
      navbarType: false,
      mtype: "",
    };
  },
  components: {
    NavBar,
  },
  methods: {
    searchSummoner() {
      this.$store.state.summoner = {
        name: this.summonerName,
        searchType: this.searchType,
        mtype: this.mtype,
      };
      this.$router
        .push("/home/" + this.$store.state.summoner.name)
        .catch(() => {});
    },
  },
};
</script>

<style lang=""></style>
