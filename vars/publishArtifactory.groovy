def call(String serverid) {
    sh "echo Publishing Artifact Info..."
    rtPublishBuildInfo (
                    serverId: "${serverid}"
                )
}
