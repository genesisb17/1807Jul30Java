import { MainRoutingModule } from './main-routing.module';

describe('MainRoutingModule', () => {
  let mainRoutingModule: MainRoutingModule;

  beforeEach(() => {
    mainRoutingModule = new MainRoutingModule();
  });

  it('should create an instance', () => {
    expect(mainRoutingModule).toBeTruthy();
  });
});
