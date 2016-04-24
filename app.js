new Vue({
    el: '#app',
    data: {
        downloads: []
    },
    ready: function() {
        // GET request
        this.$http({url: 'https://api.github.com/repos/DayZ-Minecraft/DayZ-Minecraft/releases', method: 'GET'}).then(function (response) {
            this.downloads = response.data
        }, function (response) {
            // error callback
        });
    },
    filters: {
        marked: marked,
        formatDate: function (v) {
            return v.replace(/T|Z/g, ' ')
        },
        adfly: function (v) {
            return 'http://adf.ly/5078838/' + v.replace('https://', '');
        }
    }
})
