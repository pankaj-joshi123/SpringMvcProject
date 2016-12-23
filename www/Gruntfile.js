module.exports=function(grunt) {
	

grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
 

 uglify: {
	option: {
  	  manage:false
	},
	mytarget: {
 	 files: {
   	  'compress/ugliJS2.js':['app/**.js']
	  }
	}
  },

 ngAnnotate: {
    options: {
        singleQuotes: true
    },
    app: {
        files: {
         'app/author.js': ['app/author.js']
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
 	  'compress/htmlMin.html':['app/**.html']
      }
    }
  },

  watch: {
       options:{livereload:true},

       files:['app/*.html','app/*.js','app/modules/**'],
       tasks:['build']
  },

  express:{
     all:{
       options:{
          port:9000,
          hostname:'localhost',
          bases:['.'],
          livereload:true
       }
     }
  }

});

  grunt.registerTask("build",['htmlmin','ngAnnotate','uglify'])
  grunt.registerTask("server",['express','watch'])

  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-htmlmin');
  grunt.loadNpmTasks('grunt-ng-annotate');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-express');
  grunt.loadNpmTasks('grunt-parallel');
  grunt.loadNpmTasks('grunt-contrib-livereload');
};

