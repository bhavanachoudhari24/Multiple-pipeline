// List all service directories
def services = ["service_1", "service_2", "service_3"]

services.each { svc ->
    pipelineJob("pipeline-${svc}") {

        description("Pipeline job for ${svc}")

        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url("https://github.com/bhavanachoudhari24/Multiple-pipeline.git")
                        }
                        branch("*/main")
                    }
                }
                // Jenkinsfile path inside folder
                scriptPath("${svc}/Jenkinsfile")
            }
        }
    }
  // Auto-trigger after creation
    queue("pipeline-${svc}")
}