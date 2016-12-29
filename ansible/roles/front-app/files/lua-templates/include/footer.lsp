<script src="/public/dist/vendor/jquery/2.2.4/jquery-2.2.4.min.js"></script>
<script src="/public/dist/vendor/vue/vue.js"></script>
<script src="https://cdn.jsdelivr.net/vue.resource/1.0.3/vue-resource.min.js"></script>

<script type="text/javascript">
var app = new Vue({
  el: '#search-box',
  data: {
    suggestionList:[],
		query: ""
  },
  methods: {
    getdata: function(){

        var context = this;
        var requestFuncion = function _request(__this){
          __this.$http.get('/getdata', {params: {"q": __this.query}}).then((response) => {
            if(response.ok && response.body && response.body.length > 0){
              var wordsArray = response.body;
              var arrayLength = wordsArray.length;
              var newArray = [];
              for (var i = 0; i < arrayLength; i+=2) {
                  newArray.push({'word': wordsArray[i], 'score':wordsArray[i+1] });
              }
              __this.suggestionList = newArray;
            }else{
              __this.suggestionList = [];
            }
          }, (response) => {
            console.error(response.statusText);
            console.error(response.body);
          });
        }

        setTimeout(function(){requestFuncion(context)}, 200);

    }
  }
});

</script>
