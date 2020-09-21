package 行为型模式.state;

/**
 * 不能抽奖状态
 */
public class NoRaffleState implements State {
    //初始化时传入活动引用，扣除积分后改变其状态
    RaffleActivity raffleActivity;

    public NoRaffleState(RaffleActivity raffleActivity) {
        this.raffleActivity = raffleActivity;
    }

    //当前状态是可以扣积分，扣除后将状态设置成可以抽奖的状态
    @Override
    public void deductMoney() {
        System.out.println("扣除50积分成功，您可以抽奖了");
        raffleActivity.setState(raffleActivity.getCanRaffleState());
    }

    //当前状态不能抽奖
    @Override
    public boolean raffle() {
        System.out.println("扣了积分才能抽奖哟");
        return false;
    }

    //当前状态不能发奖品
    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }
}
