# notification-lambda

# how to sync code from another repo
git clone <EKS BitBucket SSH URL>
cd <EKS Bitbucket folder>
git switch develop
git pull # get latest code from develop
git remote add ecs <ECS BitBucket SSH URL>
git remote -v # verify ECS origin is added
git fetch --all
git switch feature/eks-sync
git merge develop # resolve any potential conflicts
git push

# how to merge from develop to branch
git switch develop
git pull
git switch branch-123
git merge develop # merge current branch-123 with develop
git push
