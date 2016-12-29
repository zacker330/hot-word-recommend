{%
layout = "layouts/default.lsp"
local  title = "index"
%}
<div class="frmSearch" id="search-box">
	<input v-on:keyup="getdata" v-model="query" type="text"  placeholder="" />
	<div id="suggestion-box">
    <ul>
      <li v-for="suggestion in suggestionList">
        \{{ suggestion.word }}: \{{ suggestion.score }}
      </li>
    </ul>
  </div>
</div>
