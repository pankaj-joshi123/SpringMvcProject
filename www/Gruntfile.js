module.exports=function(grunt) {
	

grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
 

 uglify: {
	option: {
  	  manage:false
	},
	mytarget: {
 	 files: {
   	  'www/ugliJS2.js':['www/**.js']
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
  }

});

  grunt.registerTask("build",['htmlmin','ngAnnotate','uglify'])

  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-htmlmin');
  grunt.loadNpmTasks('grunt-ng-annotate');
};

