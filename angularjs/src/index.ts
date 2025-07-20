class HelloWorld {

    private field: number = 100;

    public print(): void {
        console.log(this.field);
    }
}

export const hello = new HelloWorld()