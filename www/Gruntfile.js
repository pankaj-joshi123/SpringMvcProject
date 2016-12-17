module.exports=function(grunt) {
	

grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
 

 uglify: {
	option: {
  	  manage:false
	},
	mytarget: {
 	 files: {
   	  'ugliJS2.js':['www/**.js']
	  }
	}
  },

 ngAnnotate: {
    options: {
        singleQuotes: true
    },
    app: {
        files: {
         'www/author.js': ['www/author.js']
        }
    }
},
  
  htmlmin: {
     options: {
          collapseWhitespace: true,
          conservativeCollapse: true,
          collapseBooleanAttributes: true,
          removeCommentsFromCDATA: true,
          removeOptionalTags: true
     },
     mytarget: {
	files: {
 	  'htmlMin.html':['www/**.html']
      }
    }
  },

    watch: {
       files:['www/*.html','www/*.js'],
       tasks:['build']
    }

});

  grunt.registerTask("build",['htmlmin','ngAnnotate','uglify'])

  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-htmlmin');
  grunt.loadNpmTasks('grunt-ng-annotate');
  grunt.loadNpmTasks('grunt-contrib-watch');
};

