def call() {
    sh "echo Uploading..."
    rtUpload (
        serverId: "${serverid}" ,
                    spec: """{
                            "files": [
                                    {
                                        "pattern": "*.war",
                                        "target": "libs-snapshot-local"
                                    }
                                ]
                            }"""
                )
}

// def publish(String serverid) {
//     sh "echo Publishing Artifact Info..."
//     rtPublishBuildInfo (
//                     serverId: "${serverid}"
//                 )
// }
